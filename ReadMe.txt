ReadMe File

Code status questionnaire:

Please complete this questionnaire by selecting the appropriate answer for each question. Then include this file in the code that you send to your customers.



Image manipulations:

Mosaic an image implementation: Y
Script command to mosaic an image: N (Their text option closes text prompt after trying to load initial image without any exceptions or message of any kind)
Mosaic an image from GUI: Y


Program:

Program runs by running main? Y
Program runs correctly using -file option? N (Their text option closes text prompt after trying to load initial image without any exceptions or message of any kind)
Program runs correctly using -text option? N (Their text option closes text prompt after trying to load initial image without any exceptions or message of any kind)
Program runs correctly (opens GUI) with no command-line options? Y



We implemented the image mosaicing by first using their command pattern design we created a new class named Mosaic which implemented the ImageCommand they 
created and took in a int of how many seeds should be used.

After testing to make sure the ImageCommand Mosaic worked we looked at the MVC design of their code and found they're view ImageFrame was handling the 
actionlistners for the buttons that should be handled by the controller. To fix this we moved the actionlisteners to the controller ControllerFeatures
and created getters in the view. This allowed us to extend ImageFrame to a new class of BetterImageFrame where we added the mosaic button and
mosaic factor that would show on the GUI.

Next we worked on extending the controller after restructuring the the orginal controller ControllerFeatures. We created a new class named BetterControllerFeatures
and implemented ImageFeatures. We then used delegation to of the orginal controller to execute the actionlisters from the orginal inaddition to adding our
Mosaic actionlister. And used delegation to have our new processCommand method to call the ControllerFeaturs processCommand.