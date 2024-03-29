import React from 'react';
import { AppRegistry, StyleSheet, Text, View, Button } from 'react-native';
import { NativeModules } from 'react-native';

class HelloWorld extends React.Component {
	constructor() {
		super();

		// setTimeout(() => {
		// 	console.log('Running start...');
		// 	const Bridge = NativeModules.DCTest;
		// 	Bridge.start();
		// }, 15000);

		// setTimeout(() => {
		// 	this.telemetry('Testing Motors...');
		// 	this.runMotor();
		// }, 20000);
		//
		// setInterval(() => {
		// 	console.log('Trying telemetry...');
		// 	this.telemetry('HELLO!');
		// }, 15000);

		setInterval(() => console.log('Testing...'), 1000);
	}

	telemetry(value) {
		const Bridge = NativeModules.DCTest;
		motor = Bridge.telemetry(value);
	}

	runMotor() {
		const Bridge = NativeModules.DCTest;
		Bridge.getDCMotor('left', (motor) => Bridge.setPower(motor, 0.5));
	}

	render() {
		console.log('Test: ', 'VALUE');
		debugger;

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
