
public class Main {
    public static void main(String[] args) {

        String url = "http://94.198.50.185:7081/api/users";

        Util util = new Util();

        StringBuilder result = new StringBuilder();

        User userToAdd = new User(3L, "James", "Brown", (byte) 33);

        result.append(util.save(userToAdd));

        System.out.println(util.save(userToAdd));

        System.out.println(util.getAll());

        User userToPatch = new User(3L, "Thomas", "Shelby", (byte) 33);

        result.append(util.patch(userToPatch));

        System.out.println(util.patch(userToPatch));

        System.out.println(util.getAll());

        String responseOnDELETEMeth = util.delete(3);

        result.append(responseOnDELETEMeth);

        System.out.println(responseOnDELETEMeth);

        System.out.println(util.getAll());

        System.out.println(result);

    }
}
