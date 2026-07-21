class ThroneInheritance {

    class Person {
        String name;
        List<Person> children;

        Person(String name) {
            this.name = name;
            children = new ArrayList<>();
        }
    }

    private Person king;
    private Map<String, Person> family;
    private Set<String> dead;

    public ThroneInheritance(String kingName) {
        king = new Person(kingName);
        family = new HashMap<>();
        family.put(kingName, king);
        dead = new HashSet<>();
    }

    public void birth(String parentName, String childName) {
        Person parent = family.get(parentName);
        Person child = new Person(childName);

        parent.children.add(child);
        family.put(childName, child);
    }

    public void death(String name) {
        dead.add(name);
    }

    public List<String> getInheritanceOrder() {
        List<String> order = new ArrayList<>();
        dfs(king, order);
        return order;
    }

    private void dfs(Person person, List<String> order) {

        if (!dead.contains(person.name))
            order.add(person.name);

        for (Person child : person.children)
            dfs(child, order);
    }
}
