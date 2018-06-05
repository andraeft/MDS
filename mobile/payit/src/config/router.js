import { StackNavigator, SwitchNavigator, TabNavigator } from 'react-navigation';
import HomeScreen from '../screens/HomeScreen';
import SigninScreen from '../screens/SigninScreen';
import SignupScreen from '../screens/SignupScreen';
import SearchScreen from '../screens/SearchScreen';
import ChatScreen from '../screens/ChatScreen';
import TransactionHistoryScreen from '../screens/TransactionHistoryScreen';

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

export const SignedIn = TabNavigator(
  {
    Main: {
      screen: HomeScreen,
    },
    Search: {
      screen: SearchScreen,
      navigationOptions: {
        title: 'Search',
      },
    },
    Chat: {
      screen: ChatScreen,
      navigationOptions: {
        title: 'Chat',
      },
    },
    TransactionHistory: {
      screen: TransactionHistoryScreen,
      navigationOptions: {
        title: 'History',
      },
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
