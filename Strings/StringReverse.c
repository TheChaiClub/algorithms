#include <stdio.h>
#include <string.h>
#include <stdlib.h>

void reverse(char* str)
{
    int len = strlen(str);
    int i=0;
    char temp;
    
    for (i=0; i < len/2; i++)
    {
        temp = str[i];
        str[i] = str[len - i - 1];
        str[len - i - 1] = temp;
    }
}

int main()
{
    // Note: you have to allocate memory here otherwise the compiler may decide
    // to use "read only" block of memory
    char* str = malloc(256);
    strcpy(str, "Hello World");
    
    reverse(str);
    printf("%s\n", str);
    return 0;
}

