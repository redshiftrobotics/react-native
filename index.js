import React from 'react';
import { AppRegistry, StyleSheet, Text, View, Button } from 'react-native';
import { NativeModules } from 'react-native';

class HelloWorld extends React.Component {
	runMotor() {
		const Bridge = NativeModules.DCTest;
		motor = Bridge.getDCMotor('left');
		Bridge.setPower(motor, 0.5);
	}

	render() {
		console.log('Test: ', 'VALUE');

		return (
			<View style={styles.container}>
				<Text style={styles.hello}>Press to spin the motor</Text>
				<Button
					style={styles.hello}
					title="Start"
					onPress={() => this.runMotor()}
				/>
			</View>
		);
	}
}
var styles = StyleSheet.create({
	container: {
		flex: 1,
		justifyContent: 'center',
	},
	hello: {
		fontSize: 20,
		textAlign: 'center',
		margin: 10,
	},
});

AppRegistry.registerComponent('MyReactNativeApp', () => HelloWorld);
