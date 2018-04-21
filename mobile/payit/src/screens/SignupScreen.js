import React from 'react';
import { View } from 'react-native';
import { Card, Button, FormLabel, FormInput } from 'react-native-elements';

export default () => (
  <View style={{ paddingVertical: 20 }}>
    <Card>
      <FormLabel>Email</FormLabel>
      <FormInput placeholder="Email address..." />
      <FormLabel>Password</FormLabel>
      <FormInput secureTextEntry placeholder="Password..." />
      <FormLabel>Confirm Password</FormLabel>
      <FormInput secureTextEntry placeholder="Confirm Password..." />

      <Button buttonStyle={{ marginTop: 20 }} background-color="#03A9F4" title="SIGN UP" />
      <Button
        buttonStyle={{ marginTop: 20 }}
        background-color="transparent"
        title="SIGN IN"
        textStyle={{ color: '#bcbec1' }}
      />
    </Card>
  </View>
);
