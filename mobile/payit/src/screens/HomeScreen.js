import React, { Component } from 'react';
import { View, Text, Button } from 'react-native';
import { connect } from 'react-redux';
import PropTypes from 'prop-types';

import { fetchHome } from '../actions/home';

class HomeScreen extends Component {
  constructor() {
    super();
    this.logCeva = this.logCeva.bind(this);
  }

  componentWillMount() {
    this.props.initializeHome();
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
        <Button title="Disp" color="#841584" onPress={this.props.initializeHome} />
      </View>
    );
  }
}

HomeScreen.propTypes = {
  message: PropTypes.string.isRequired,
  loading: PropTypes.bool,
  initializeHome: PropTypes.func.isRequired,
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
  };
}

export default connect(mapStateToProps, mapDispatchToProps)(HomeScreen);
