import React, { Component } from 'react';
import { View, Text } from 'react-native';
import { connect } from 'react-redux';
import PropTypes from 'prop-types';

import { fetchHome } from '../actions/home';
import UserDataForm from '../components/UserDataForm';
import Picture from '../components/Picture';
import { editUser } from '../api/homeApi';

class HomeScreen extends Component {
  componentWillMount() {
    this.props.initializeHome();
  }

  render() {
    return (
      <View
        style={{
          flex: 1,
          backgroundColor: 'steelblue',
        }}
      >
        <View style={{ flex: 3, flexDirection: 'row' }}>
          <View style={{ aspectRatio: 1, flex: 1 }}>
            <Picture url={this.props.profilePic} />
          </View>
          <View style={{ flex: 1 }}>
            <Text>{`Bank rating: ${this.props.bankRating}`}</Text>
            <Text>{`Slave rating: ${this.props.slaveRating}`}</Text>
          </View>
        </View>
        <View style={{ flex: 5 }}>
          <Text>Date despre user</Text>
          <UserDataForm
            firstName={this.props.firstName}
            lastName={this.props.lastName}
            email={this.props.email}
            action={(data) => {
              console.log(this.props.userId);
              console.log(data);
              editUser(this.props.userId, data.firstName, data.lastName, data.email)
                .then(() => { console.log('edit reusit'); })
                .catch((e) => { console.log(e, 'editare nereusita'); });
            }}
          />
        </View>
      </View>
    );
  }
}

HomeScreen.propTypes = {
  userId: PropTypes.number.isRequired,
  profilePic: PropTypes.string,
  bankRating: PropTypes.number,
  slaveRating: PropTypes.number,
  firstName: PropTypes.string,
  lastName: PropTypes.string,
  email: PropTypes.string,
};

HomeScreen.defaultProps = {
  profilePic: 'def',
  bankRating: 0,
  slaveRating: 0,
  firstName: 'def',
  lastName: 'def',
  email: 'def',
};

function mapStateToProps(state) {
  return { ...state.home, userId: state.home.id, loading: state.transaction.loading };
}

function mapDispatchToProps(dispatch) {
  return {
    initializeHome: () => dispatch(fetchHome()),
    // privateRequest: () => dispatch(privateHome()),
  };
}

export default connect(mapStateToProps, mapDispatchToProps)(HomeScreen);
