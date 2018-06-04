import React, {Component} from 'react';
import { View, Text, FlatList, ActivityIndicator } from 'react-native';
import { Card, Button, FormLabel, FormInput, List, ListItem } from 'react-native-elements';



const Componenta = ({lista}) => (
    <View style={{ paddingVertical: 20 }}>
        <Button buttonStyle={{ marginTop: 20 }} background-color="#03A9F4" title="new transaction"
        />
    <List containerStyle={{ borderTopWidth: 0, borderBottomWidth: 0, display: 'flex', flexDirection: 'row', borderColor: 'pink' }}>
        <FlatList 
        data={[{key: 'de primit'}, {key: 'de dat'}]}
        renderItem={({item}) => <Text>{item.key}</Text>}
        />
    </List>

    <List containerStyle={{ borderTopWidth: 0, borderBottomWidth: 0 }}>
        <FlatList 
        data={lista}
        renderItem={({listItem}) => (
            <Text>{JSON.stringify(lista)}</Text> 
          )}
        />
    </List> 
    </View>
);

Componenta.defaultProps = {
    lista: [
        {   key: 1,
            donator: 'andrei',
            primitor: 'anca',
            suma: 200
        },
        {   key: 2,
            donator: 'julieta',
            primitor: 'romeo',
            suma: 400
        }
    ]
}

export default Componenta;