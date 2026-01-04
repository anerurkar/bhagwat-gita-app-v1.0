export interface Shloka {
  number: number;
  sanskrit: string;
  translation: string;
}

export interface Chapter {
  chapter: number;
  title: string;
  shlokas: Shloka[];
}
