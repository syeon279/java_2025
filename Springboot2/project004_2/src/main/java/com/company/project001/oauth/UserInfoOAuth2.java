package com.company.project001.oauth;

public interface UserInfoOAuth2 {
	
	String getProvier();
	String getProvierId();
	String getEmail();
	String getNickname();
	String getImage();
	
}

//privider = "goole" "kakao" "naver" "facebook"
// prividerId = google → sub. kakao/facebook → id, naver →  response
// username = prividerId 설정
// nickname = 각 사이트에 등록한 이름으로 설정
/*

<google>
{
   sub=103058387739722400130, 
   name=안효정, 
   given_name=효정, 
   family_name=안, 
   picture=https://lh3.googleusercontent.com/a/AEdFTp5SiCyTaOLog9sDPN6QhWwsUj7xPbfj4HQF0fdC=s96-c, email=chb20050@gmail.com, 
   email_verified=true, 
   locale=ko
}

<kakao>
{
    id=2632890179, 
    connected_at=2023-01-22T08:17:54Z, 
    properties = {nickname=효정}, 
    kakao_account = {
        profile_nickname_needs_agreement=false, 
        profile={nickname=효정}, 
        has_email=true, 
        email_needs_agreement=false, 
        is_email_valid=true, 
        is_email_verified=true, 
        email=sally03915@naver.com
    }
}

<naver>
{
    resultcode=00, 
    message=success, 
    response = {
        id=pvdq1FSG3VZlD7Cp3JuWfAFi-3xir6A-WPlP5f8kXIo, email=sally03915@naver.com, 
        name=안효정
    }
}

*/