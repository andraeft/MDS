import React, { Component } from 'react';
import { View, Text, Button } from 'react-native';
import { connect } from 'react-redux';
import PropTypes from 'prop-types';

import { fetchHome, privateHome } from '../actions/home';

import { login } from '../api/homeApi';

const authenticate = () => {
  console.log('authenticating...');
  console.log(login === undefined ? 'nope' : 'este');
  login('user', 'password')
    .then((data) => {
      console.log('autentificare cu succes');
      console.log(data);
    })
    .catch((err) => {
      console.log('eroare autentificare');
      console.log(err);
    });
};

class HomeScreen extends Component {
  constructor() {
    super();
    this.logCeva = this.logCeva.bind(this);
  }

  logCeva() {
    console.log(this.props);
  }

  render() {
    return (
      <View
        style={{
          flex: 1,
          backgroundColor: '#ddd',
          justifyContent: 'center',
          alignItems: 'center',
        }}
      >
        <Text>{this.props.message}</Text>
        <Text>{this.props.loading ? 'loading' : 'not loading'}</Text>
        <Button title="Ceva" color="#841584" onPress={this.logCeva} />
        <Button title="Public" color="#841584" onPress={this.props.initializeHome} />
        <Button title="Private" color="#841584" onPress={this.props.privateRequest} />
        <Button title="Login" color="#841584" onPress={authenticate} />
      </View>
    );
  }
}

HomeScreen.propTypes = {
  message: PropTypes.string.isRequired,
  loading: PropTypes.bool,
  initializeHome: PropTypes.func.isRequired,
  privateRequest: PropTypes.func.isRequired,
};

HomeScreen.defaultProps = {
  loading: false,
};

function mapStateToProps(state) {
  return { message: state.home.message, loading: state.transaction.loading };
}

function mapDispatchToProps(dispatch) {
  return {
    initializeHome: () => dispatch(fetchHome()),
    privateRequest: () => dispatch(privateHome()),
  };
}

export default connect(mapStateToProps, mapDispatchToProps)(HomeScreen);
