import { StackNavigator, SwitchNavigator } from 'react-navigation';
import HomeScreen from '../screens/HomeScreen';
import SigninScreen from '../screens/SigninScreen';
import SignupScreen from '../screens/SignupScreen';

export const SignedOut = StackNavigator(
  {
    SignUp: {
      screen: SignupScreen,
      navigationOptions: {
        title: 'Sign Up',
      },
    },
    SignIn: {
      screen: SigninScreen,
      navigationOptions: {
        title: 'Sign In',
      },
    },
  },
  {
    initialRouteName: 'SignIn',
  },
);

export const SignedIn = StackNavigator(
  {
    Main: {
      screen: HomeScreen,
    },
  },
  {
    headerMode: 'none',
  },
);

// export const RootNavigator = SignedIn;

export const RootNavigator = SwitchNavigator(
  {
    SignedOut: {
      screen: SignedOut,
    },
    SignedIn: {
      screen: SignedIn,
    },
  },
  {
    initialRouteName: 'SignedOut',
  },
);
