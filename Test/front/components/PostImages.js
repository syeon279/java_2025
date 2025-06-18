import React from 'react';
import PropTypes from 'prop-types';

const imageStyle = {
  width: '100%',
  maxWidth: '200px',
  height: 'auto',
  objectFit: 'cover',
  borderRadius: '8px',
  display: 'block',
  marginBottom: '8px',
};

const halfImageStyle = {
  width: '49%',
  height: 'auto',
  objectFit: 'cover',
  borderRadius: '8px',
  display: 'inline-block',
};

const PostImages = ({ images }) => {
  if (images.length === 1) {
    return (
      <img
        role="presentation"
        src={`http://localhost:3065/${images[0].src}`}
        alt={images[0].src}
        style={imageStyle}
      />
    );
  }

  if (images.length === 2) {
    return (
      <>
        <img
          role="presentation"
          src={`http://localhost:3065/${images[0].src}`}
          alt={images[0].src}
          style={halfImageStyle}
        />
        <img
          role="presentation"
          src={`http://localhost:3065/${images[1].src}`}
          alt={images[1].src}
          style={{ ...halfImageStyle, marginLeft: '2%' }}
        />
      </>
    );
  }

  // 3개 이상일 경우 (간단히 첫 이미지만 표시)
  return (
    <img
      role="presentation"
      src={`http://localhost:3065/${images[0].src}`}
      alt={images[0].src}
      style={imageStyle}
    />
  );
};

PostImages.propTypes = {
  images: PropTypes.arrayOf(PropTypes.shape({
    src: PropTypes.string,
  })).isRequired,
};

export default PostImages;