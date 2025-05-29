import React , {useEffect, useState,useMemo} from 'react';
import { List, Button, Card } from 'antd';
import { UserDeleteOutlined } from '@ant-design/icons';
import { useDispatch } from 'react-redux';
import { UNFOLLOW_REQUEST, REMOVE_FOLLOWER_REQUEST } from '../reducers/user';

//              팔로잉/팔로우   팔로잉리스트/팔로우리스트    3개이벤트각각  로딩
const FollowList = ({ header, data, onClickMore, loading }) => {
  const dispatch = useDispatch();
  const [localData, setLocalData] = useState(data);

  useEffect(() => { setLocalData(data);  } , [data])

  //const onClickCancel = (id) => { };
  const onClickCancel = (id) => () => { 
    setLocalData((prev) => prev.filter((user) => user.id !== id));
    if (header === '팔로잉') {
      dispatch({   type:UNFOLLOW_REQUEST ,  data:id  });
    } else { 
      dispatch({   type:REMOVE_FOLLOWER_REQUEST ,  data:id  });
    }
  };
  ///////////////////////////////// code 
  const style = useMemo(() => ({  margin:'3%' , backgroundColor:'white' , padding:'3%'  }) , []);
  ///////////////////////////////// view
  return (<List  style={style}
    grid ={{ gutter : 4 , xs : 2, md: 3 }}
    size="small"
    header={<div> {header} </div>}
    loadMore={<div style={{ textAlign: 'center' }} >
      <Button onClick={onClickMore} loading={loading}>더보기</Button>
    </div>}
    dataSource={localData}  
    renderItem={(item)=>(
    <List.Item>
      <Card actions={[<UserDeleteOutlined  key="user"  onClick={onClickCancel(item.id)}  />]}>
        <Card.Meta  description={item.nickname}   />
      </Card>
    </List.Item>
   )}
  />
  )
 };  // https://ant.design/components/icon?locale   ()=>{}  , ()=>()

export default FollowList;