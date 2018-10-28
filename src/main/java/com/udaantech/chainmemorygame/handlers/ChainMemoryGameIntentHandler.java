package com.udaantech.chainmemorygame.handlers;

import static com.amazon.ask.request.Predicates.intentName;
import static com.udaantech.chainmemorygame.core.Game.COUNTRY_SLOT;
import static com.udaantech.chainmemorygame.core.Game.GAMEOVER;
import static com.udaantech.chainmemorygame.core.Game.TITLE;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Intent;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Slot;
import com.amazon.ask.response.ResponseBuilder;
import com.udaantech.chainmemorygame.core.Game;
import java.util.Map;
import java.util.Optional;

public class ChainMemoryGameIntentHandler implements RequestHandler {

  @Override
  public boolean canHandle(HandlerInput input) {
    return input.matches(intentName("ChainMemoryGame"));
  }

  @Override
  public Optional<Response> handle(HandlerInput input) {


    IntentRequest intentRequest = (IntentRequest) input.getRequestEnvelope().getRequest();
    Intent intent = intentRequest.getIntent();
    Map<String, Slot> slots = intent.getSlots();
    Slot countrySlot = slots.get(COUNTRY_SLOT);
    String countryUtterance = countrySlot.getValue();

    Game game = new Game();
    String speechText = game.getSpeechText(countryUtterance);

    ResponseBuilder response = input.getResponseBuilder()
        .withSpeech(speechText)
        .withSimpleCard(TITLE, speechText);

    if (!speechText.toLowerCase().contains(GAMEOVER)) {
      response = response.withShouldEndSession(false);
    }

    return response.build();
  }
}
