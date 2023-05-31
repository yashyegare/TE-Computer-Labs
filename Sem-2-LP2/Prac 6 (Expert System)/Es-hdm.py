class Ticket:
    def __init__(self, id, category, description):
        self.id = id
        self.category = category
        self.description = description
        self.status = 'Open'

class HelpDeskExpert:
    def __init__(self): #newly created object
        self.tickets = []

    def create_ticket(self):
        id = int(input("Enter ticket ID: "))
        category = input("Enter ticket category: ")
        description = input("Enter ticket description: ")

        #Ticket object 
        ticket = Ticket(id, category, description)
        # Add ticket to the list of tickets using append method
        self.tickets.append(ticket)
        print(f'Ticket {id} created successfully.')

    def close_ticket(self):
        id = int(input("Enter ticket ID to close: "))

         # Search for the ticket in the list of tickets
        for ticket in self.tickets:
            if ticket.id == id:
                ticket.status = 'Closed'
                print(f'Ticket {id} closed successfully.')
                return
        print(f'Ticket {id} not found.')

    def view_tickets(self):
        if len(self.tickets) == 0:
            print('No tickets found.')
            return

        for ticket in self.tickets:
            print(f'Ticket ID: {ticket.id}')
            print(f'Category: {ticket.category}')
            print(f'Description: {ticket.description}')
            print(f'Status: {ticket.status}')
            print('-------------------------')

# Example usage
help_desk = HelpDeskExpert()

while True:
    print("\nHelp Desk Management System ")
    print("1. Create a ticket")
    print("2. Close a ticket")
    print("3. View all tickets")
    print("4. Exit")

    choice = input("Enter your choice (1-4): ")

    if choice == '1':
        help_desk.create_ticket()
    elif choice == '2':
        help_desk.close_ticket()
    elif choice == '3':
        help_desk.view_tickets()
    elif choice == '4':
        print("Exiting the program...")
        break
    else:
        print("Invalid choice. Please try again.")
