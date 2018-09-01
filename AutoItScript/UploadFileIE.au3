#include <File.au3>
#include <MsgBoxConstants.au3>
WinWaitActive("Choose File to Upload");
ControlFocus("Choose File to Upload","","Edit1"); // This method sets input focus to 'File name' text box.
Local $sTestPath = _PathFull(".\FilesForUpload\TestFile.txt")
ControlSetText("Choose File to Upload","","Edit1",$sTestPath); // This method input file path of a control.
ControlClick("Choose File to Upload","","Button1"); //This method click on 'Open' button of file uploader.