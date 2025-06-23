package com.company.project001.oauth;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.company.project001.domain.Member;
import com.company.project001.member.MemberMapper;
import com.company.project001.member.MemberRole;
import com.company.project001.member.MemberUserDetails;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {
	
	private final MemberMapper memberMapper;

	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		
	    try {
	        OAuth2User oAuth2User = super.loadUser(userRequest);

	        log.info("✅ OAuth Provider: {}", userRequest.getClientRegistration().getRegistrationId());
	        log.info("✅ Attributes: {}", oAuth2User.getAttributes());

	        // ... 기존 로직 ...
			log.info("1. ........getAttributes : {} ,", oAuth2User.getAttributes());
			
			String provider = userRequest.getClientRegistration().getRegistrationId();
			UserInfoOAuth2 info = null;
			if("google".equals(provider)) {
				info = new UserInfoGoogle(oAuth2User.getAttributes());
			} else if("kakao".equals(provider)) {
				info = new UserInfoKakao(oAuth2User.getAttributes());
			} else if("naver".equals(provider)) {
				info = new UserInfoNaver(oAuth2User.getAttributes());
			}
			if (info == null) {
			    log.error("❌ UserInfoOAuth2 객체 생성 실패: provider = {}", provider);
			    throw new OAuth2AuthenticationException("UserInfoOAuth2 생성 실패");
			}

			String username = provider +"_" + info.getProvierId();
			String email = info.getEmail();
			String nickname = info.getNickname();
			String image = info.getImage();
			
			Member member = memberMapper.findByUsername(username);
			// insert
			if(member == null) {
				member = Member.builder()
						.username(username)
						.provider(provider)
						.email(email)
						.nickname(nickname)
						.image(image)
						.role(MemberRole.MEMBER)
						.build();
				memberMapper.insert(member);
			} else {
				member.setImage(image);
				memberMapper.update(member);
			}
			

	        return new MemberUserDetails(member, oAuth2User.getAttributes());

	    } catch (Exception e) {
	        log.error("❌ OAuth 로그인 중 에러 발생: {}", e.getMessage(), e);
	        OAuth2Error error = new OAuth2Error("oauth2_login_error", e.getMessage(), null);
	        throw new OAuth2AuthenticationException(error, e.getMessage(), e);
	    }
	}

	
	

}

//PrincipalOauth2UserService