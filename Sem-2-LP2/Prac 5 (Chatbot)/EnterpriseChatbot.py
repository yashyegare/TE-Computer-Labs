import random

# predefined responses
responses = {
    "hi": "Hello, I am an Enterprise Bot! How can i help you?",
    "services": "We offer the following services:\n- IT Support\n- Software Dev\n- Cloud Computing\n- Data Analytics\nWhich service are you interested in?",
    "it support": "Great, let me transfer you to our IT support team.",
    "software development": "Great, let me transfer you to our software development team.",
    "cloud computing": "Great, let me transfer you to our cloud computing team.",
    "data analytics": "Great, let me transfer you to our data analytics team.",
    "default": "I'm sorry, I didn't understand. Can you please rephrase?"
}

# function to get response
def get_response(user_input):
    user_input = user_input.lower()  # The .lower() method returns lowercased strings
   
    if "it support" in user_input:
        return responses["it support"]
    elif "software dev" in user_input:
        return responses["software dev"]
    elif "cloud computing" in user_input:
        return responses["cloud computing"]
    elif "data analytics" in user_input:
        return responses["data analytics"]
    elif "services" in user_input:
        return responses["services"]
    elif "hi" in user_input:
        return responses["hi"]
    elif "bye" in user_input:
        return "Thank you for contacting, have a great day!"
    else:
        return responses["default"]

print("Hello, welcome to Enterprise Bot! How can i help you?")
while True:
    user_input = input("You: ")
    if "bye" in user_input:
        print(get_response(user_input))
        break
    else:
        print(get_response(user_input))
