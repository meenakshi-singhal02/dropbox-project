#include <File.au3>
WinWaitActive("File Upload");
ControlFocus("File Upload","","Edit1"); // This method sets input focus to 'File name' text box.
Local $sTestPath = _PathFull(".\FilesForUpload\TestFile.txt")
ControlSetText("File Upload","","Edit1",$sTestPath); // This method input file path of a control.
ControlClick("File Upload","","Button1"); //This method click on 'Open' button of file uploader.