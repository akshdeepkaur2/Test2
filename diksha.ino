// This #include statement was automatically added by the Particle IDE.
#include <InternetButton.h>

// This #include statement was automatically added by the Particle IDE.
#include <InternetButton.h>

// create an internet button object
InternetButton button = InternetButton();


void setup() {
    // setup the button
    button.begin();
    Particle.function("key",controlNumberOfLights);
}

void loop() {
    // GOAL: TUrn on 3 lights

    // VERSION 1: Turn on all lights
    // button.allLedsOn(232, 142, 218);

    // VERSION 2: Turn on 3 lights
    
}

// C  function will return in int
int controlNumberOfLights(String command) {
    // 1. get number of lights from app
    // ----------------------------------
    // Number of lights always comes in as a string
    // - therefore, you must convert string -> int
    // - atoi() and c_str() are built in c functions
    // to convert string --> int
    int howManyLights = atoi(command.c_str());

    // do some validation to make sure
    // user entered valid number of lights
    // -----------------

    // ERROR CASE 1: negative number
    if (howManyLights < 0) {
        howManyLights = 0;
    }
    // ERROR CASE 2: number > 11
    else if (howManyLights > 11) {
        howManyLights = 11;
    }

    // turn on those number of lghts
    for (int i = 1; i <= howManyLights; i++) {
        button.ledOn(i, 0, 100, 100);
    }

    // exit the function
    return 1;
}
