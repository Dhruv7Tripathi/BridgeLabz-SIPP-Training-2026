import java.util.*;

public class AddressBookManagementSystem {

  private final List<Contact> contacts = new ArrayList<>();
  private final Map<String, Contact> contactsByName = new HashMap<>();
  private final Set<String> usedPhoneNumbers = new HashSet<>();

  public boolean addContact(String name, String phoneNumber, String email, String photo) {
    if (name == null || phoneNumber == null || email == null) {
      return false;
    }

    String tName = name.trim();
    String tPhone = phoneNumber.trim();
    String tEmail = email.trim();
    String tPhoto = photo == null ? "" : photo.trim();

    String normalizedName = normalize(tName);
    String normalizedPhone = normalize(tPhone);

    if (normalizedName.isEmpty() || normalizedPhone.isEmpty()) {
      return false;
    }

    if (contactsByName.containsKey(normalizedName) || usedPhoneNumbers.contains(normalizedPhone)) {
      return false;
    }

    Contact contact = new Contact(tName, tPhone, tEmail, tPhoto);
    contacts.add(contact);
    contactsByName.put(normalizedName, contact);
    usedPhoneNumbers.add(normalizedPhone);
    return true;
  }

  public Contact searchName(String name) {
    if (name == null) {
      return null;
    }
    return contactsByName.get(normalize(name));
  }

  public boolean deleteContact(String name) {
    if (name == null) {
      return false;
    }

    String normalizedName = normalize(name);
    Contact contact = contactsByName.remove(normalizedName);
    if (contact == null) {
      return false;
    }

    contacts.remove(contact);
    usedPhoneNumbers.remove(normalize(contact.getPhoneNumber()));
    return true;
  }

  public List<Contact> displayContacts() {
    List<Contact> sortedContacts = new ArrayList<>(contacts);
    Collections.sort(sortedContacts, Comparator.comparing(Contact::getName, String.CASE_INSENSITIVE_ORDER));
    return sortedContacts;
  }

  public int size() {
    return contacts.size();
  }

  private String normalize(String value) {
    return value == null ? "" : value.trim().toLowerCase();
  }

  public static final class Contact {
    private final String name;
    private final String phoneNumber;
    private final String email;
    private final String photo;

    public Contact(String name, String phoneNumber, String email, String photo) {
      this.name = name;
      this.phoneNumber = phoneNumber;
      this.email = email;
      this.photo = photo;
    }

    public String getName() {
      return name;
    }

    public String getPhoneNumber() {
      return phoneNumber;
    }

    public String getEmail() {
      return email;
    }

    public String getPhoto() {
      return photo;
    }

    // @Override
    // public String toString() {
    // return "Contact{" +
    // "name='" + name + '\'' +
    // ", phoneNumber='" + phoneNumber + '\'' +
    // ", email='" + email + '\'' +
    // ", photo='" + photo + '\'' +
    // '}';
    // }

    @Override
    public boolean equals(Object o) {
      if (this == o)
        return true;
      if (!(o instanceof Contact))
        return false;
      Contact contact = (Contact) o;
      return Objects.equals(name, contact.name) && Objects.equals(phoneNumber, contact.phoneNumber);
    }

    @Override
    public int hashCode() {
      return Objects.hash(name, phoneNumber);
    }
  }
}
