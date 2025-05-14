module.exports = (sequelize , DataTypes) => { 
    const Hashtag = sequelize.define('Hashtag', {  // mysql images 테이블- 자동 s
        name: {
            type: DataTypes.STRING(20), 
            allowNull:false
        }
    }, {
        charset: 'utf8mb4', 
        collate: 'utf8mb4_general_ci'  // 이모티콘
    });
  
    Hashtag.associate = (db) => { 
        db.Hashtag.belongsToMany(db.Post, { through: 'PostHashtag' });  
    };
    
    return Hashtag;
  };


/*
9) 해쉬태그 관리 -    [models] - hashtag.js
> 기본테이블값
    id   기본값
    name   varchar(20) 필수
    createdAt , updatedAt   --

>  관계설정

   -  해시태그는 많은 게시글를 갖는다.  belongsToMany   ( Hashtag ) 중간테이블 : PostHashtag       
*/