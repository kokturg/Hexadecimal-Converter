# Hexadecimal-Converter

The program which converts hexadecimal numbers into their decimal representation and vice versa.

Prerequisites
1) Hexadecimal number is a string with a '0x' prefix.

Example: 0xFF; 0x102c

2) All strings not having the '0x' prefix  are treated as decimal numbers.

Requirements:
1) Input can be given in two different ways depending on the presence of an -i command line parameter:
- The input is given by the user directly from the console if no -i parameter is used.
- The input is read from a file if the -i parameter is used. The parameter has the following format: -i<file path>, where the <file path> represents a path of the input file. If the path is not rooted, it is relative to the current directory.
2) Input form:
- Input can contain 1..N values, separated by " " or "," or ";" or a line break (CR, LF or CRLF).
- Both hexadecimal and decimal values can be present in the same string.

Example: 
0xAC, 23456; 0x12 345
  125, 89

3) Output format:
- A table including 2 columns: "input value" and "output value".
- Column headers shall not be present.
- The columns shall be separated by <space> characters.
- If an input value has an incorrect format and cannot be parsed, then the output column shall contain the following text: "invalid hexadecimal value" or "invalid decimal value".
4) Two different output channels shall be used depending on the presence of an -o command line parameter:
- The output is printed directly to the console if no -o parameter is present.
- The output is written into a file if the -o parameter is used. The parameter has the following format: -o<file path> where <file path> represents a path of the output file. If the path is not rooted, it is relative to the current directory. In an unlikely case the input and output path are the same, the program shall issue a warning and process the output as if no -o parameter was present.
 
