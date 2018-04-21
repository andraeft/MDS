import { StackNavigator } from 'react-navigation';
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

export const RootNavigator = SignedOut;

// export const RootNavigator = (function (signedIn) {
//   return SwitchNavigator(
//     {
//       SignedIn: {
//         screen: SignedIn,
//       },
//       SignedOut: {
//         screen: SignedOut,
//       },
//     },
//     {
//       initialRouteName: signedIn ? 'SignedIn' : 'SignedOut',
//     },
//   );
// }(false));
