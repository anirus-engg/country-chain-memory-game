/*
     Copyright 2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.

     Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file
     except in compliance with the License. A copy of the License is located at

         http://aws.amazon.com/apache2.0/

     or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS,
     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for
     the specific language governing permissions and limitations under the License.
*/

package com.udaantech.chainmemorygame.handlers;

import static com.amazon.ask.request.Predicates.intentName;
import static com.udaantech.chainmemorygame.core.Game.TITLE;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import java.util.Optional;

public class HelpIntentHandler implements RequestHandler {

  @Override
  public boolean canHandle(HandlerInput input) {
    return input.matches(intentName("AMAZON.HelpIntent"));
  }

  @Override
  public Optional<Response> handle(HandlerInput input) {
    String speechText = "You start the game by saying a country's name and I will chain it "
        + "with another country's name. The whole chain must be repeated before a new name is added.";
    String repromptText = "You say United States. For me to add a new country's name, "
        + "I will have to say United States, Canada. Then you repeat the chain before adding "
        + "a new country's name like United States, Canada, India and so on.";

    return input.getResponseBuilder()
        .withSimpleCard(TITLE, speechText)
        .withSpeech(speechText)
        .withReprompt(repromptText)
        .withShouldEndSession(false)
        .build();
  }
}
