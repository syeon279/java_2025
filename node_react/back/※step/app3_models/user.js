module.exports = (  sequelize , DataTypes   ) => { 
  /// const User
  const User = sequelize.define('User', {//users테이블  - 자동으로 s 붙어서 생성
    //id 기본값으로 자동설정
    email: {
      type: DataTypes.STRING(30), // STRING, TEXT, BOOLEAN, INTEGER, FLOAT, DATETIME
      allowNull: false, // 필수
      unique : true ,  // 고유값
    }, 
    nickname: {
      type: DataTypes.STRING(30), // STRING, TEXT, BOOLEAN, INTEGER, FLOAT, DATETIME
      allowNull: false, // 필수
    },
    password: {
      type: DataTypes.STRING(100), // STRING, TEXT, BOOLEAN, INTEGER, FLOAT, DATETIME
      allowNull: false, // 필수
    },
  }, {
    charset : 'utf8', 
    collate : 'utf8_general_ci'  // 한글저장  
  });  
  /// 관계설정
  User.associate = (db) => { 
    db.User.hasMany(db.Post);
    db.User.hasMany(db.Comment);
    db.User.belongsToMany(db.Post, { through: 'Like',   as: 'Liked' });
    db.User.belongsToMany(db.User, { through: 'Follow', as: 'Followers', foreignKey: 'FollowingId' });
    //                                                      user.getFollowers() 
    //  Follow 테이블에서 팔로우하는사람 (FollowingId) 을 기준으로 관계설정 - 팔로우하는 사람 ID
    db.User.belongsToMany(db.User, { through: 'Follow', as: 'Followings' , foreignKey:'FollowerId'    });
    //                                                      user.getFollowings()
  }; 
  return User;
};


/*
   -유저는 많은 post를 가진다.  1:다      hasMany
   -유저는 많은 comment를 가진다.  1:다     hasMany
   - 좋아요 :  User객체와 Post 객체사이에  다:다    belongsToMany  / 테이블명 :like / 별칭: liked
   - 팔로우 : 내가 올린게시물을 보는 사람  
     User객체에서   User 테이블사이  		belongsToMany  / 테이블명 : follow / 별칭: followers / fk : follwingId
     
   - 팔로잉 : 내가 팔로우한사람의 게시물을 볼수 있는 상태
     User객체에서   User 테이블사이  		belongsToMany  / 테이블명 : follow / 별칭: followings / fk : follwerId


5)  멤버관리 -    [models] - user.js
> 기본테이블값
    id   기본값
    email        varchar(30)    필수, unique
    nickname  varchar(30)    필수, unique
    password  varchar(30)    필수, unique
    createdAt , updatedAt   --
   
> 관계설정	
    관계설정
    - 유저는 많은 post를 가진다.  1:다      hasMany
    - 유저는 많은 comment를 가진다.  1:다     hasMany
    - 좋아요 :  User객체와 Post 객체사이에  다:다    belongsToMany  / 테이블명 :like / 별칭: liked  
      ※ user.getLiked()   특정사용자의 좋요한 게시물목록
      유저는 많은 글에대한 좋아요를 남길수가 있고.
      글도    많은 유저가   좋아요를 남길수 있다.


	post1	user1
	post1	user2
	post2	user1
	post2	user2
	
   ※팔로우(게시물볼께)  개념 : 팔로워 / 팔로잉
		내가 [장동건]     팔로우	   나는 [장동건] 의 팔로잉  ( 장동건의 게시물을 볼수 있음)
		[장동건] 이 나를 팔로우             [장동건] 은 나의 팔로워  ( 내 게시물을 볼수 있음)

    - 팔로우 ( 게시물볼게, 어떻게살아? )
		[팔로우(내가볼께)	팔로잉(당신게시물)] 
me	      	me		장동건			         장동건
me		      me		winter		      	   winter
me		      me		카리나		        	  카리나
장동건		  장동건	winter			         winter

   - 팔로우 : 내가 올린게시물을 보는 사람  
     User객체에서   User 테이블사이  		belongsToMany  / 테이블명 : follow / 별칭: followers / fk : follwingId
     
   - 팔로잉 : 내가 팔로우한사람의 게시물을 볼수 있는 상태
     User객체에서   User 테이블사이  		belongsToMany  / 테이블명 : follow / 별칭: followings / fk : follwerId

	※  fk 컬럼의 어떤아이디를 참고 
	 >   winter를 누가 팔로잉했는지 찾으려면  
	 >   winter팔로우  id를 먼저 찾고
	 >   following 확인

*/

