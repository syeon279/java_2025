import React, { useCallback, useState } from "react";
import PropTypes from 'prop-types';
import { PlusSquareFilled } from '@ant-design/icons';
import ImagesZoom from '../components/ImagesZoom';

const PostImages = ({ images }) => {
    //////////////////// code
    const [showImageZoom, setShowImageZoom] = useState(false);
    const onZoom = useCallback(() => { setShowImageZoom(true); }, []);
    const onClose = useCallback(() => { setShowImageZoom(false); }, []);

    if (images.length === 1) {
        return (
            <>
                <img role="presentation" src={`http://localhost:3065/${images[0].src}`} alt={images[0].src} onClick={onZoom} />
                {showImageZoom && <ImagesZoom images={images} onClose={onClose} />}
            </>
        );
    }
    if (images.length === 2) {
        return (
            <>
                <img role="presentation" src={images[0].src}
                    alt={images[0].src} onClick={onZoom} style={{ width: '50%', height: '100%', display: 'inline-block' }} />
                <img role="presentation" src={images[1].src}
                    alt={images[1].src} onClick={onZoom} style={{ width: '50%', height: '100%', display: 'inline-block' }} />
                {showImageZoom && <ImagesZoom images={images} onClose={onClose} />}
            </>
        )
    }
    /*
    if (images.length === 3) {
        return (
            <>
                <img role="presentation" src={images[0].src}
                    alt={images[0].src} onClick={onZoom} style={{ width: '50%', height: '100%', display: 'inline-block' }} />
                <img role="presentation" src={images[1].src}
                    alt={images[1].src} onClick={onZoom} style={{ width: '50%', height: '100%', display: 'inline-block' }} />
                <img role="presentation" src={images[2].src}
                    alt={images[2].src} onClick={onZoom} style={{ width: '50%', height: '100%', display: 'inline-block' }} />
                {showImageZoom && <ImagesZoom images={images} onClose={onClose} />}
            </>
        )
    }
        */
    //////////////////// view 여러개
    return (
        <>
            <div>
                <img role="presentation" src={`http://localhost:3065/${images[0].src}`} alt={images[0].src} width="90%" onClick={onZoom} />
                <div role="presentation"
                    style={{ display: 'inline-block', width: '10%', textAlign: 'center', verticalAlign: 'middle' }} onClick={onZoom}>
                    <PlusSquareFilled />
                    <br />
                    {images.length - 1}개의 사진 더보기
                </div>
            </div>
            {showImageZoom && <ImagesZoom images={images} onClose={onClose} />}
        </>
    );
};

PostImages.propType = {
    //images: PropTypes.arrayOf(PropTypes.object).isRequired
    images: PropTypes.arrayOf(PropTypes.shape({
        src: PropTypes.string
    })).isRequired
}

export default PostImages;