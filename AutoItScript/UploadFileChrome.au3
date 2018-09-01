#include <File.au3>
WinWaitActive("Open");
ControlFocus("Open","","Edit1"); // This method sets input focus to 'File name' text box.
sleep(1000)
Local $sTestPath = _PathFull(".\FilesForUpload\TestFile.txt")
ControlClick("Open","","Edit1");
ControlSetText("Open","","Edit1",$sTestPath); // This method input file path of a control.
ControlClick("Open","","Button1"); //This method click on 'Open' button of file uploader.