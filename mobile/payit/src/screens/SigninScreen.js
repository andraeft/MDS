import React from 'react';
import { View } from 'react-native';
import { Card, Button, FormLabel, FormInput } from 'react-native-elements';
import { login } from '../api/authentication';

const formData = {
  username: null,
  password: null,
};

const signinClick = (nav) => {
  console.log('authenticating...');
  console.log(formData);
  login(formData.username, formData.password)
    .then((data) => {
      console.log('authentication success');
      console.log(data);
      nav.navigate('SignedIn');
    })
    .catch((err) => {
      console.log('error authenticating');
      console.log(err);
    });
};

export default ({ navigation }) => (
  <View style={{ paddingVertical: 20 }}>
    <Card>
      <FormLabel>Username</FormLabel>
      <FormInput
        placeholder="Username..."
        onChangeText={(text) => {
          formData.username = text;
        }}
      />
      <FormLabel>Password</FormLabel>
      <FormInput
        secureTextEntry
        placeholder="Password..."
        onChangeText={(text) => {
          formData.password = text;
        }}
      />

      <Button
        buttonStyle={{ marginTop: 20 }}
        backgroundColor="#03A9F4"
        title="SIGN IN"
        onPress={() => signinClick(navigation)}
      />
      <Button
        buttonStyle={{ marginTop: 20 }}
        backgroundColor="#03A9F4"
        title="SIGN UP"
        onPress={() => navigation.navigate('SignUp')}
      />
    </Card>
  </View>
);
