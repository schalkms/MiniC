#include <stdio.h>
#include <polyglot.h>

#define QUOTE(...) #__VA_ARGS__

int main() {
    polyglot_eval("minic", QUOTE(
        void main() {
          int a, b, cs;
          a = 3;
          b = 4;
          printf("Hello World from MiniC!");
          cs = (a * a) + (b * b);
          printf("SVP:");
          printf(cs);
        }
    ));
    printf("Hello World from C\n");
    return 0;
}
