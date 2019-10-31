# A simple translator made in Java.

It works quite simply: a request is made to the [Google Translate site in its basic version](https://translate.google.com/m) passing the useful parameters: the language of the original text, the language for the text to be translated and the text itself. After obtaining the source code of the returned page, the translation is extracted.

# Quick Guide
- To see which languages are available, go to the [Language](https://github.com/KPr0jects/simple-translator/blob/master/src/Language.java) class.
- You can see how the translation process is performed in the [Translator](https://github.com/KPr0jects/simple-translator/blob/master/src/Translator.java) class.

An example of expected output:
```
Enter text to translate:
Olá, Mundo!
Translated text: Hello World!
```

As it is quite simple, it is quite easy to adapt to other languages or use for other purposes.
**Feel free to contribute and use.**
