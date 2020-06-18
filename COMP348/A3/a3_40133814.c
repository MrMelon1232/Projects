//Question 1
#include <stdio.h>
#include <stdlib.h>
void CallFun(int *);
int main(){
int a = 3;
CallFun(&a);
printf("%d" , a);
}

void CallFun(int *a){
*a = 17;
}

//Question 2
#include <stdio.h>
#include <stdlib.h>
int main(){
    int arr[5] = {1,13,5,17,11};
    DisplayArray (arr,5);
    SelectionSort(arr);
    printf("\n");
    DisplayArray(arr,5);
}

void DisplayArray(int *a, int *b){
    for(int i = 0; i < b; i++)
    {
        printf("%d, ", a[i]);
        
    }
}

void SelectionSort(int *arr){
int size = sizeof(*arr) + 1;
int i,j,temp;

for(i = 0; i < size; i++)
        for(j = i+1; j < size; j++)
        {
            if(*(arr+i)>*(arr+j))
            {
                temp=*(arr+j);
                *(arr+j)=*(arr+i);
                *(arr+i)=temp;
            }
        }
}

//Question 3
#include <stdio.h>
#include <stdlib.h>

typedef struct{
    char* title;
    float price;
}Book;

float AverageBookPrice(Book *, int);
void Display(Book *, int);
Book* Add(Book *, int);

int main(){
    int n,j;
    int len = 5;
    printf("Enter number of elements: ");
    scanf("%d", &n);
    Book *arr = malloc(n * sizeof(*arr));
    
    for(j = 0; j < n; j++){
        arr[j].title = (char*)malloc(len* sizeof(char));
        printf("Enter title of book %d: ", j+1);
        scanf("%s", arr[j].title);
        printf("Enter price of book %d: ", j+1);
        scanf("%f", &arr[j].price);
    }
    
        Display(arr,n);
        printf("Average book price is: %f\n", AverageBookPrice(arr,n));
        
        Book *arr1 = Add(arr,n);
        Display(arr1,n + 1);
        printf("Average book price is: %f\n", AverageBookPrice(arr1, n + 1));
        return 0;

}

void Display(Book *arr, int n){
int i;
    for(i = 0; i < n; i++)
    {
        
        printf("Title: %s\t Price: %f\n", arr[i].title , arr[i].price);
    }

}

float AverageBookPrice(Book *arr, int n)
{
    float sum = 0;
    float avg = 0;
    int i;
    for(i = 0; i < n; i++)
    {
        sum+= arr[i].price;
    }
    avg = sum / n;
    return avg;
}

Book* Add(Book *arr, int n){
    int i;
    int len = 5;
    Book *arr1 = malloc((n + 1) * (sizeof(*arr1)));
    
    
    for(i = 0; i < n + 1; i++)
    {
    if(arr[i].title != NULL){
       arr1[i].title = strdup(arr[i].title);
       arr1[i].price = arr[i].price;
    }
    else{
        arr1[i].title = (char*)malloc(len* sizeof(char));
        printf("Enter title of book %d: ", i+1);
        scanf("%s", arr1[i].title);
        printf("Enter price of book %d: ", i+1);
        scanf("%f", &arr1[i].price);
    }
    }
    free(arr);
    return arr1;
}