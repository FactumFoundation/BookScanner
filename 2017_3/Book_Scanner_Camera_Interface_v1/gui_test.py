from Tkinter import *
import os


class App:

    def __init__(self, master):

        frame = Frame(master)
        frame.pack()

        self.listbox = Listbox(master)
        self.listbox.pack()

        self.listbox.insert(END, "Image list")

        gifsdict = {}

        dirpath = '/home/factum/Desktop/svn/Book_Scanner_Camera_Interface_v1/images'
        for gifname in os.listdir(dirpath):
            if not gifname[0].isdigit():
                continue
            gifpath = os.path.join(dirpath, gifname)
            gif = PhotoImage(file=gifpath)
            gifsdict[gifname] = gif
            self.listbox.insert(END, gifname)

        self.listbox.pack()

        img = Label()
        img.pack()

        def list_entry_clicked(*ignore):
            imgname =  self.listbox.get( self.listbox.curselection()[0])
            img.config(image=gifsdict[imgname])

        self.listbox.bind('<ButtonRelease-1>', list_entry_clicked)


        # Delete selected item
        self.deleteBt = Button(master, text="Delete",
                   command=lambda listbox=self.listbox: self.listbox.delete(ANCHOR))
        self.deleteBt.pack()

        self.exitBt = Button(
            frame, text="Exit", command=frame.quit
            )
        self.exitBt.pack(side=LEFT)

        self.shutterBt = Button(frame, text="Capture", command=self.say_hi)
        self.shutterBt.pack(side=LEFT)

    def say_hi(self):
        print "shoot!!"

root = Tk()

app = App(root)

root.mainloop()
root.destroy() # optional; see description below 
