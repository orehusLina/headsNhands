#include <iostream>
#include <stdlib.h>
#include <time.h>

using namespace std;

//специальный тип данных, чтобы узнать - правильно ли создан объект класса или нет
enum StatusEr
{
    OK, Err
};

class Creature {
private:
    bool Status;

protected:
    string Name; // имя существа
    int Attack;  // атака (целое число от 1 до 30)
    int Defend;  // защита (целое число от 1 до 30)
    pair<double,double> Health;  // пара - максимальное и текущее здоровье
    pair<int,int> Yron; // урон - диапазон натуральных чисел M-N

public:
    Creature() { Status = Err; }  // конструктор по умолчанию 

    Creature(string N, int A, int D, pair<double,double> H, pair<int, int> Y)
    {
        if (N == "" || A < 1 || A > 30 || D < 1 || D > 30 || H.second < 1 || H.second > H.first) //заданы недопустимые значения полей 
            // объект будет создан со статусом ошибка, чтобы нельзя было его использовать
            Status = Err;
        else
        {
            Name = N; // имя существа
            Attack = A;
            Defend = D;
            Health = H;
            Yron = Y;
            Status = OK;
        }
    }
    // геттеры
    string getName() { return Name; } // задается при создании, невозможно поменять
    int getAttack() { return Attack; }
    int getDefend() { return Defend; }
    pair<int, int> getHealth() { return Health; }
    pair<int,int> getYron() { return Yron; } 
    // специальный
    bool getStatus() { return Status; }
    // сеттеры   
    void setAttack(int x) { Attack = x; }
    void setDefend(int d) { Defend = d; }
    void setHealth(pair<int,int> h) { Health = h; }
    //void setYron(pair<int, int> y) { Yron = y; }
    
    ~Creature() {} // деструктор базового класса 
    

    bool checkDead() {
        if (Health.second < 1) return true;
        return false;
    }

    void kickSomeAss(Creature& fighter, Creature& victim) {
        int Modifier = fighter.Attack - victim.Defend + 1;
        for (int i = 0; i < max(1, Modifier); ++i) {
            int k = rand() % 6 + 1; // генерация чисел от 1 до 6 включительно
            if (k > 4) {
                int kick = rand() % fighter.Yron.second + fighter.Yron.first; // берем произвольное значение из промежутка урона аткующего
                victim.Health.second -= kick;
                if (victim.checkDead()) return;
            }
        }
    }

};

class Programmer : public Creature
{
private:
    int leftHeal; // количество оставшихся хилок
    bool Status;
public:
    Programmer() { Status = Err; }  // конструктор по умолчанию 
    Programmer(string N, int A, int D, pair<int, int> H, pair<int, int> Y) : Creature(N, A, D, H, Y) {
        Status = OK;
        leftHeal = 4;
    }
    ~Programmer() {} // деструктор  класса
    virtual int getLeftHeal() { return leftHeal; }
    virtual void useLeftHeal() { leftHeal -= 1; }
    // специальный
    virtual bool getStatus() { return Status; }
    
    virtual void healYourself(Programmer& p) {
        if (leftHeal) {
            useLeftHeal();
            Health.second += (double) 0.3 * Health.first;
            cout << "Теперь здоровье игрока составляет " << Health.second << " hp.\n";
        }
    }

    // вывод информации о программисте - перегрузка вывода
    friend ostream& operator<< (ostream& out, Programmer p)
    {
        out << "Программист " << p.getName() << " имеет атаку " << p.Attack << ", защиту " 
        << p.Defend << " и урон " << p.Yron.first << '-' << p.Yron.second << "." <<
        "\nЗдоровье составляет " << p.Health.second << " из " << p.Health.first << 
        ".\nОставшиеся хилки: " << p.leftHeal << " шт.\n\n";
        return out;
    }
};

class Manager : public Creature
{
private:
    bool Status;
public:
    Manager() { Status = Err; }  // конструктор по умолчанию 
    Manager(string N, int A, int D, pair<int, int> H, pair<int, int> Y) : Creature(N, A, D, H, Y) {
        Yron = Y;
        Status = OK;
    }
    ~Manager() {} // деструктор класса 
    // специальный
    bool getStatus() { return Status; }

    // вывод информации о менеджере - перегрузка вывода
    friend ostream& operator<< (ostream& out, Manager p)
    {
        out << "Проджект " << p.getName() << " имеет атаку " << p.Attack << ", защиту "
            << p.Defend << " и урон " << p.Yron.first << '-' << p.Yron.second << "." <<
            " Здоровье составляет " << p.Health.second << " из " << p.Health.first <<
            ".\n\n";
        return out;
    }
};

template <class X>
struct node {
    X* inf;
    node* next;
    node* prev;
};

template <class X>
class List {
private:
    node<X>* head;
    node<X>* tail;
public:
    List() { head = NULL; tail = NULL; }
    void push(X* p);
    void del(node<X>* r);
    void print();
    bool find(string x); //  найти одного конкретного существа
    //void prohod(List& Lst, List& Lst2);
    node<X>* findReturn(string x);
    void kill(string x, List& lst);
    node<X>* returnRand(List& lst);

};

template <class X>
void List<X>::push(X* p) { 
    node<X>* r = new node<X>;
    r->inf = p;
    r->next = NULL;
    if (!head && !tail) {
        r->prev = NULL;
        head = r;
    }
    else {
        tail->next = r;
        r->prev = tail;
    }
    tail = r;
}

template <class X>
void List<X>::del(node<X>* r) {
    if (r == head && r == tail) {
        head = NULL;
        tail = NULL;
    }
    else if (r == head) {
        head = head->next;
        head->prev = NULL;
    }
    else if (r == tail) {
        tail = tail->prev;
        tail->next = NULL;
    }
    else {
        r->next->prev = r->prev;
        r->prev->next = r->next;
    }
    delete r;
}

template <class X>
void List<X>::print()
{
    node<X>* r = head;
    while (r != NULL) {
        cout << *(r->inf);
        r = r->next;
    }
    cout << '\n';
}

template <class X>
bool List<X>::find(string x) {
    node<X>* r = head;
    while (r != NULL) {
        if ((*(r->inf)).getName() == x)
            return true;
        r = r->next;
    }
    return false;
}

template <class X>
node<X>* List<X>::findReturn(string x) {
    node<X>* r = head;
    while (r != NULL) {
        if ((*(r->inf)).getName() == x)
            return r;
        r = r->next;
    }
}

template <class X>
void List<X>::kill(string x, List& lst) {
    if (lst.find(x)) {
        node<X>* r = lst.findReturn(x);
        lst.del(r);
        cout << x << " трагически погиб...\n\n";
    }
}

template <class X>
node<X>* List<X>::returnRand(List& lst) {
    int cnt = rand() % 20;
    node<X>* r = head;
    while (cnt--) {
        r = r->next;
        if (r == NULL) r = head;
    }
    return r;
}

int main()
{
    setlocale(LC_ALL, "Russian");
    // Штат программистов:

    // string N, int A, int D, pair<double, double> H, pair<int, int> Y, int lHeal
    Programmer p1("Vadim", 20, 30, { 200, 200 }, { 1, 200 });    
    if (p1.getStatus() != OK) cout << "Программист не добавлен!\n";

    Programmer p2("Optoed", 30, 20, { 150, 150 }, { 1, 150 });
    if (p2.getStatus() != OK) cout << "Программист не добавлен!\n";

    Programmer p3("Androsov", 10, 30, { 100, 100 }, { 1, 100 });
    if (p3.getStatus() != OK) cout << "Программист не добавлен!\n";

    Programmer p4("Sapkovskiy", 30, 10, { 100, 100 }, { 1, 120 });
    if (p4.getStatus() != OK) cout << "Программист не добавлен!\n";




    List<Programmer> lstProg;
    lstProg.push(&p1);
    lstProg.push(&p2);
    lstProg.push(&p3);
    lstProg.push(&p4);

    Manager m1("Radoslav", 20, 30, { 100, 100 }, { 1, 100 });
    Manager m2("Molchanov", 30, 20, { 100, 100 }, { 1, 100 });
    Manager m3("Stalin", 50, 40, { 100, 100 }, { 1, 100 });
    Manager m4("CheGevara", 40, 50, { 100, 100 }, { 1, 100 });

    List<Manager> lstMan;
    lstMan.push(&m1);
    lstMan.push(&m2);
    lstMan.push(&m3);
    lstMan.push(&m4);

    bool wantToPlay = true;
    while (wantToPlay) {
        cout << "\nВ компании работают следующие программисты: \n";
        lstProg.print();
        cout << "Выберите своего бойца (введите имя): \n";
        string player; cin >> player;
        Programmer fighter = *((lstProg.findReturn(player))->inf);
        cout << fighter;

        Manager enemy = *((lstMan.returnRand(lstMan))->inf);
        cout << enemy;
        int cnt = 2;
        while (!fighter.checkDead() && !enemy.checkDead()) {
            cout << "Проджект зовет на " << cnt << " дейли за день\n";
            cout << "Введите 1, чтобы защищаться.\nВведите 2, чтобы атаковать.\n";
            int but; cin >> but;
            if (but == 1) {
                cout << "Программист " << fighter.getName() << " признался, что таска не готова, и выпросил еще немного времени.\n\n";
                enemy.kickSomeAss(enemy, fighter);
                if (fighter.checkDead()) {
                    lstProg.kill(fighter.getName(), lstProg);
                    break;
                }
            }
            else if (but == 2) {
                cout << "Программист " << fighter.getName() << " в очередной раз спросил актуальные требования к проекту. Проджект " << enemy.getName() << " смущен.\n";
                fighter.kickSomeAss(fighter, enemy);
                if (enemy.checkDead()) {
                    lstMan.kill(enemy.getName(), lstMan);
                    cout << "Ура!!!\n";
                    break;
                }
            }
            cout << "\nАктуальные статы: \n\n";
            cout << fighter;
            cout << enemy;
            if (fighter.getLeftHeal()) {
                cout << "Введите 1, чтобы использовать хилку. Введите 0, чтобы пропустить\n";
                cin >> but;
                if (but) {
                    fighter.healYourself(fighter);
                }
            }
            ++cnt;
        }
        cout << "Сыграть еще раз? Yes/No\n";
        string ans; cin >> ans;
        if (ans == "No" || ans == "no" || ans == "NO" || ans == "n" || ans == ":wq" || ans == ":q!")
            wantToPlay = false;
    }

    system("pause");
}