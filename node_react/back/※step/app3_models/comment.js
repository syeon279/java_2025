module.exports = (sequelize , DataTypes) => { 
    const Comment = sequelize.define('Comment', {  // mysql comments 테이블- 자동 s
        content: {
            type: DataTypes.TEXT, 
            allowNull : false,
        },
    }, {
        charset: 'utf8mb4', 
        collate: 'utf8mb4_general_ci'  // 이모티콘
    });
  
    Comment.associate = (db) => { 
        db.Comment.belongsTo(db.User);
        db.Comment.belongsTo(db.Post);
    };
    return Comment;
  };
/*
8)  댓글 관리 -    [models] - comment.js
> 기본테이블값
    id   기본값
    content  text 필수
    createdAt , updatedAt   --

>  관계설정
      댓글은  (User)에 속해있다   belongsTo
      댓글은  (Post)에 속해있다   belongsTo
*/