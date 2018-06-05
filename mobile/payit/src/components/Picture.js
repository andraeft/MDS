import React from 'react';
import { Image } from 'react-native';

export default ({ url }) => (
  <Image source={{ uri: `http://192.168.43.26:8080/files/${url}` }} style={{ width: 200, height: 200 }} />
);
