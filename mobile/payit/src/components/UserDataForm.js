import React, { Component } from 'react';
import { View, Button } from 'react-native';
import t from 'tcomb-form-native';

const User = t.struct({
  firstName: t.String,
  lastName: t.String,
  email: t.String,
});

const { Form } = t.form;

export default class UserDataForm extends Component {
  constructor(props) {
    super(props);
    console.log(props);

    this.handleSave = (act) => {
      if (act) {
        act(this.form.getValue());
      }
    };
  }

  render() {
    return (
      <View>
        <Form
          type={User}
          value={{
            firstName: this.props.firstName,
            lastName: this.props.lastName,
            email: this.props.email,
          }}
          ref={(c) => { this.form = c; }}
        />
        <Button
          title="Save!"
          onPress={() => this.handleSave(this.props.action)}
        />
      </View>
    );
  }
}

