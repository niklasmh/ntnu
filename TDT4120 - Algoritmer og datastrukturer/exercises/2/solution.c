#include <stdio.h>
#define MAX_BUFFER 1000

int main() {
    char line[MAX_BUFFER];
    scanf("%[^\n]", line);
    printf("Line: %s\n", line);
    
    int wordCount = 0;
    char words[MAX_BUFFER];
    while (scanf("%s", words) != EOF)
        printf("Word %d: %s\n", ++wordCount, words);

    

    for(int i = 0; i < wordCount; i++) {
        printf("%s", words[i])
    }

    return 0;
}
