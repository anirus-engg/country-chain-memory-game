package com.udaantech.chainmemorygame;


import com.amazon.ask.Skill;
import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.Skills;
import com.udaantech.chainmemorygame.handlers.*;

public class ChainMemoryGameStreamHandler extends SkillStreamHandler {

  public ChainMemoryGameStreamHandler() {
    super(getSkill());
  }

  private static Skill getSkill() {
    return Skills.standard()
        .addRequestHandlers(
            new ChainMemoryGameIntentHandler(),
            //new MyColorIsIntentHandler(),
            new LaunchRequestHandler(),
            new CancelandStopIntentHandler(),
            new SessionEndedRequestHandler(),
            new HelpIntentHandler(),
            new FallbackIntentHandler())
        // Add your skill id below
        .withSkillId("Add you amazon skill id here")
        .build();
  }
}
