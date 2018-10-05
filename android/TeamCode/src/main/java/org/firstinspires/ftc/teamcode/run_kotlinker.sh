#!/bin/bash

kotlinc KopMode.kt -cp  \
  -cp /Users/zoe/robotics/soccerbot/libs/Blocks-release-sources.jar \
  -cp /Users/zoe/robotics/soccerbot/libs/Inspection-release-sources.jar \
  -cp /Users/zoe/robotics/soccerbot/libs/FtcCommon-release-sources.jar \
  -cp /Users/zoe/robotics/soccerbot/libs/RobotCore-release-sources.jar \
  -cp /Users/zoe/robotics/soccerbot/libs/Hardware-release-sources.jar \
  -cp /Users/zoe/robotics/soccerbot/libs/Vuforia.jar
