#include <stdio.h>
#define MAX_BUFFER 1000

int main() {
    char line[MAX_BUFFER];
    scanf("%[^\n]", line);
    printf("Line: %s\n", line);
    
    int i = 0;
    char words[MAX_BUFFER];
    while (scanf("%s", words) != EOF)
        printf("Word %d: %s\n", ++i, words);
    
    return 0;
}
