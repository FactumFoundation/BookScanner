const int cameraLeftPin =  9;  
const int flashLeftPin =  10; 
const int cameraRightPin =  8;      
const int flashRightPin =  7;    

int lastSwitchInput = HIGH;

void setup() {

  Serial.begin(9600);

  pinMode(cameraLeftPin, OUTPUT);
  pinMode(flashLeftPin, OUTPUT);
  pinMode(cameraRightPin, OUTPUT);
  pinMode(flashRightPin, OUTPUT);
  pinMode(2,INPUT_PULLUP);

  digitalWrite(flashLeftPin, LOW);
  digitalWrite(cameraLeftPin, LOW);
  digitalWrite(flashRightPin, LOW);
  digitalWrite(cameraRightPin, LOW);

  delay(300);
}

void loop() {
  int switchInput = digitalRead(2);

  if(switchInput == LOW && lastSwitchInput == HIGH)
  {
    Serial.println("t");
    delay(200);
  } 
  lastSwitchInput = switchInput;
  serialEvent(); 
}


void serialEvent() {
  while (Serial.available() > 0) {
    char message = Serial.read();

    if (message == 'b'){
      digitalWrite(cameraRightPin, HIGH);
      delay(110); 
      digitalWrite(flashRightPin, HIGH);
      delay(50);
      digitalWrite(cameraLeftPin, HIGH);
      delay(110);
      digitalWrite(flashLeftPin, HIGH); 
      delay(300);
      digitalWrite(cameraLeftPin, LOW);
      digitalWrite(cameraRightPin, LOW);
      digitalWrite(flashRightPin, LOW); 
      digitalWrite(flashLeftPin, LOW);     
    }
    if (message == 'l'){
      digitalWrite(cameraLeftPin, HIGH);
      delay(110);    
      digitalWrite(flashLeftPin, HIGH); 
      delay(50);  
      digitalWrite(cameraLeftPin, LOW);
      digitalWrite(flashLeftPin, LOW); 
    }
    if (message == 'r'){
      digitalWrite(cameraRightPin, HIGH);
      delay(110);    
      digitalWrite(flashRightPin, HIGH); 
      delay(50); 
      digitalWrite(cameraRightPin, LOW);
      digitalWrite(flashRightPin, LOW); 
    }    
  }
}








