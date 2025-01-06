
    public static Node<Integer> exe1(Node<Integer> list1, Node<Integer> list2) {
        Node<Integer> dummyHead = new Node<>(-1);
        Node<Integer> current = dummyHead;

        while (list1 != null && list2 != null) {
            if (list1.getValue() <= list2.getValue()) {
                current.setNext(list1);
                list1 = list1.getNext();
            } else {
                current.setNext(list2);
                list2 = list2.getNext();
            }
            current = current.getNext();
        }

        if (list1 != null) {
            current.setNext(list1);
        }
        if (list2 != null) {
            current.setNext(list2);
        }

        return dummyHead.getNext();
    }

    public static Node<Integer> exe2(Node<Integer> head) {
        Node<Integer> sortedHead = null;
        Node<Integer> sortedTail = null;

        while (head != null) {
            Node<Integer> minNode = head;
            Node<Integer> minPrev = null;
            Node<Integer> prev = null;
            Node<Integer> current = head;

            while (current != null) {
                if (current.getValue() < minNode.getValue()) {
                    minNode = current;
                    minPrev = prev;
                }
                prev = current;
                current = current.getNext();
            }

            if (minPrev != null) {
                minPrev.setNext(minNode.getNext());
            } else {
                head = minNode.getNext();
            }

            minNode.setNext(null);
            if (sortedTail == null) {
                sortedHead = minNode;
                sortedTail = minNode;
            } else {
                sortedTail.setNext(minNode);
                sortedTail = minNode;
            }
        }

        return sortedHead;
    }

    public static int exe3(Node<Integer> head, int value) {
        int index = 0;
        int firstIndex = -1;
        int lastIndex = -1;
        int size = 0;

        Node<Integer> current = head;
        while (current != null) {
            if (current.getValue() == value) {
                if (firstIndex == -1) {
                    firstIndex = index;
                }
                lastIndex = index;
            }
            size++;
            index++;
            current = current.getNext();
        }

        if (firstIndex == -1) {
            return -1;
        }

        return firstIndex + (size - 1 - lastIndex);
    }

    public static boolean exe4(Node<Integer> head) {
        Node<Integer> current = head;

        while (current != null) {
            Node<Integer> checker = current.getNext();
            while (checker != null) {
                if (checker.getValue().equals(current.getValue())) {
                    return false;
                }
                checker = checker.getNext();
            }
            current = current.getNext();
        }

        return true;
    }

    public static Node<Integer> exe5(Node<Integer> head) {
        Node<Integer> newHead = null;
        Node<Integer> newTail = null;

        while (head != null) {
            if (!existsInList(newHead, head.getValue())) {
                Node<Integer> newNode = new Node<>(head.getValue());
                if (newHead == null) {
                    newHead = newNode;
                    newTail = newNode;
                } else {
                    newTail.setNext(newNode);
                    newTail = newNode;
                }
            }
            head = head.getNext();
        }

        return newHead;
    }

    private static boolean existsInList(Node<Integer> head, int value) {
        Node<Integer> current = head;
        while (current != null) {
            if (current.getValue() == value) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }
