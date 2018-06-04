import React from 'react';
import { View } from 'react-native';
import { Card, Button, FormLabel, FormInput, Text } from 'react-native-elements';
import { login, register } from '../api/authentication';

const formDataUp = {
  username: null,
  password: null,
  confirmPassword: null,
};

const signupClick = (nav) => {
  console.log('authenticating...');
  console.log(formDataUp);
  if (formDataUp.password == formDataUp.confirmPassword && formDataUp.password != null)
  {register(formDataUp.username, formDataUp.password)
    .then((data) => {
      console.log('register success');
      login(formDataUp.username, formDataUp.password)
        .then((data) => {
         nav.navigate('SignedIn');}
        );
    })
    .catch((err) => {
      console.log('error registering');
      console.log(err);
    });
  }
};

export default ({navigation}) => (
  <View style={{ paddingVertical: 20 }}>
    <Card>
      <FormLabel>Username</FormLabel>
      <FormInput placeholder="Username..." 
       onChangeText={(text) => {
          formDataUp.username = text;
        }} />
      <FormLabel>Password</FormLabel>
      <FormInput secureTextEntry placeholder="Password..."
       onChangeText={(text) => {
        formDataUp.password = text;
      }} />
      <FormLabel>Confirm Password</FormLabel>
      <FormInput secureTextEntry placeholder="Confirm Password..."
       onChangeText={(text) => {
        formDataUp.confirmPassword = text;
      }} />

      <Button buttonStyle={{ marginTop: 20 }} background-color="#03A9F4" title="SIGN UP"
      onPress={() => signupClick(navigation)} />
      <Text> eroare inregistrare </Text>
    </Card>
  </View>
);
