import { StackNavigator } from 'react-navigation';
import HomeScreen from '../screens/HomeScreen';

const Navigator = StackNavigator(
  {
    Main: { screen: HomeScreen },
  },
  {
    headerMode: 'none',
  },
);

export default Navigator;
