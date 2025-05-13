module.exports = (sequelize , DataTypes) => { 
    const Image = sequelize.define('Image', {  // mysql images 테이블- 자동 s
        src: {
            type: DataTypes.STRING(200),
            allowNull:false,
        }
    }, {
        charset: 'utf8', 
        collate : 'utf8_general_ci'
    });
  
    Image.associate = (db) => { 
        db.Image.belongsTo(db.Post);
    };
    
    return Image;
    
  };
/*
7)  이미지 관리 -    [models] - image.js
> 기본테이블값
    id   기본값
    src   varchar(200)  필수
    createdAt , updatedAt   --

>  관계설정
    이미지는  게시글(Post)에 속해있다  belongsTo

*/