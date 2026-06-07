struct Node {
    int value;
    Node* next;
    Node(int val) {
        this->value = val;
        this->next = nullptr;
    }
};

class MyHashSet {
private:
    static const int SIZE = 1000;
    Node* arr[SIZE];
public:
    int hash(int val) {
        return val % SIZE;
    }
    MyHashSet() {
        for(int i = 0; i < SIZE; i++) {
            arr[i] = nullptr;
        }
    }
    void add(int key) {
        Node* n = arr[hash(key)]; 
        while (n != nullptr) {
            if (n->value == key) {
                return;
            }
            n = n->next;
        }
        Node* node = new Node(key);
        node -> next = arr[hash(key)];
        arr[hash(key)] = node;
    }
    
    void remove(int key) {
        int h = hash(key);
        Node* head = arr[h];
        Node* prev = nullptr;
        while (head != nullptr) {
            if (head -> value == key) {
                if (prev == nullptr) {
                    arr[h] = head -> next;
                }
                else {
                    prev -> next = head -> next;
                }
                delete head;
                return;
            }
            prev = head;
            head = head -> next;
        }
    }
    
    bool contains(int key) {
        Node* head = arr[hash(key)];
        while (head != nullptr) {
            if (head->value == key) {
                return true;
            }
            head = head -> next;
        }
        return false;
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */