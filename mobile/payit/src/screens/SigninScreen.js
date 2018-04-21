import React from 'react';
import { View } from 'react-native';
import { Card, Button, FormLabel, FormInput } from 'react-native-elements';

export default () => (
  <View style={{ paddingVertical: 20 }}>
    <Card>
      <FormLabel>Username</FormLabel>
      <FormInput placeholder="Username.." />
      <FormLabel>Password</FormLabel>
      <FormInput secureTextEntry placeholder="Password..." />

      <Button buttonStyle={{ marginTop: 20 }} backgroundColor="#03A9F4" title="SIGN IN" />
    </Card>
  </View>
);
