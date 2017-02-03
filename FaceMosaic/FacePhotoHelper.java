import acm.graphics.*;

public class FacePhotoHelper
{
    private static final int NUMPHOTOS = 450;

    public static GImage[] getAllPhotos()
    {
        GImage[] result = new GImage[NUMPHOTOS];
        for (int i=1; i<=NUMPHOTOS; i++)
        {
            String numLeadingZeroes;
            if (i < 10) numLeadingZeroes = "00" + i;
            else if (i<100) numLeadingZeroes = "0" + i;
            else numLeadingZeroes = "" + i;
            GImage face = new GImage("images/image_0"+numLeadingZeroes+".jpg");
            result[i-1] = face;
        }
        return result;
    }


}
