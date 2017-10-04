package edu.gcccd.csis.p1;

public class SequenceSearchImpl extends SequenceSearch {

    public SequenceSearchImpl(final String content, final String start, final String end) {
        super(content, start, end);
    }

    @Override
    public String[] getAllTaggedSequences() {
        int starterTag = this.content.indexOf(startTag);
        int enderTag = this.content.indexOf(endTag, starterTag + 1);


        String[] sa = new String[0];
       // String[] sa = {content.substring(starterTag+startTag.length(),enderTag)};

        while (starterTag != -1 && enderTag != -1)
        {
            if (startTag==endTag){
                System.out.println(content.substring(starterTag+startTag.length(),enderTag));
                sa = adds(sa,content.substring(starterTag+startTag.length(),enderTag));
                starterTag = this.content.indexOf(startTag,enderTag+1);
                enderTag = this.content.indexOf(endTag,starterTag+1);
            } else {
                System.out.println(content.substring(starterTag+startTag.length(),enderTag));
                sa = adds(sa,content.substring(starterTag+startTag.length(),enderTag));
                starterTag = this.content.indexOf(startTag,starterTag+1);
                enderTag = this.content.indexOf(endTag,enderTag+1);
            }

        }

        return sa;

    }

    @Override
    public String getLongestTaggedSequence() {
       /*
       int x = 0;
        String[] sa3 = new String[1];
        sa3 = new String[sa3.length+1];
        int max = -1;

        for (int i = 0; i<sa3.length; i++){
            if (sa3[i].length() >= max){
                x = i;
                max = sa3[i].length();
            }
        }
        return sa3[x];
        */

        int starterTag = this.content.indexOf(startTag);
        int enderTag = this.content.indexOf(endTag,starterTag+1);

        String t = "F";
        if (starterTag == -1 && enderTag == -1){
            t = null;
        }

        while (starterTag != -1 && enderTag != 1){
            System.out.println(content.substring(starterTag+startTag.length(),enderTag));
            String t2 = content.substring(starterTag+startTag.length(),enderTag);
            if (t2.length()>t.length()){
                t = t2;
            }
            if (t2.length()==t.length()){
                t = t2;
            }
            starterTag = this.content.indexOf(startTag,starterTag+1);
            enderTag = this.content.indexOf(endTag,enderTag+1);
        }

        return t;
    }

    @Override
    public String displayStringArray() {
        int starterTag = this.content.indexOf(startTag);
        int enderTag = this.content.indexOf(endTag, starterTag+1);
        String[] p = new String[0];
        String p2 = new String();

        while (starterTag != -1 && enderTag != -1){
            p = adds(p,content.substring(starterTag+startTag.length(),enderTag));
            starterTag = this.content.indexOf(startTag,enderTag+1);
            enderTag = this.content.indexOf(endTag,starterTag+1);
        }

        for (int x = 0; x < p.length; x++){
            System.out.println(p[x] + " : " + p[x].length() + "\n");
            p2 += (p[x] + " : " + p[x].length() + "\n");
        }

        return p2;
    }

    @Override
    public String toString() {
        int starterTag = this.content.indexOf(startTag);
        int enderTag = this.content.lastIndexOf(endTag, starterTag+1);
        String tS = new String();

        tS = content;
        tS = tS.replace(startTag,"");
        tS = tS.replace(endTag,"");

        return tS;
    }

}