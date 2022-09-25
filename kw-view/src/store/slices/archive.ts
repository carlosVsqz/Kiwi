import {CaseReducer, createSlice, PayloadAction} from '@reduxjs/toolkit';
import {QueryParams, ResponseState, ResponseStateDetail} from '@store/shared';
import {AuthorItem} from './author';

export enum ArchiveCoverType {
    IMAGE = 'image',
    AUDIO = 'audio',
    VIDEO = 'video',
    SLIDE = 'slide',
    SPLIT = 'split',
    DOC = 'doc',
}

export interface UserItem {
    id?: number;
    name: string;
    avatar: string | null;
}

export interface ArchiveCommentItem {
    id: 1;
    publicDate: Date;
    favourite: number;
    shared: number;
    content: string;
    user: UserItem;
    replies: Omit<ArchiveCommentItem, 'replies'>[];
}

export interface ArchiveTagItem {
    id: number;
    name: string;
}

export interface ArchiveItem {
    id?: number;
    image?: string | string[];
    category: ArchiveItemCategory;
    title?: string;
    publicDate?: Date;
    commentsCount?: number;
    quote?: string;
    author?: string;
    audio?: string;
    video?: string;
    description?: string;
    type?: ArchiveCoverType;
    comments?: ArchiveCommentItem[];
    tags?: ArchiveTagItem[];
    user: AuthorItem;
    content?: string;
    path: string;
}

export interface ArchiveItemCategory {
    id: number;
    image: string;
    name: string;
    key: string;
    quantity: number;
}

export enum ArchiveCategoriesType {
    Bar = 'bar',
}

export interface GetArchiveCategoriesParams extends QueryParams {
}

export interface GetArchiveListParams extends QueryParams {
    type_like?: string;
    isTrending_like?: boolean;
    'category.id_like'?: number | string | null;
}

export interface GetArchiveListMaronryParams extends GetArchiveListParams {
    isWide?: boolean;
}

interface ArchivesState {
    list: ResponseState<ArchiveItem>;
    related: ResponseState<ArchiveItem>;
    destination: ResponseState<ArchiveItem>;
    guide: ResponseState<ArchiveItem>;
    lastest: ResponseState<ArchiveItem>;
    trendingList: ResponseState<ArchiveItem>;
    detail: ResponseStateDetail<ArchiveItem>;
    footerList: ResponseState<ArchiveItem>;
    categories: ResponseState<ArchiveItemCategory>;
}

const initialState: ArchivesState = {
    list: {fetching: false, data: []},
    related: {fetching: false, data: []},
    destination: {fetching: false, data: []},
    guide: {fetching: false, data: []},
    lastest: {fetching: false, data: []},
    trendingList: {fetching: false, data: []},
    detail: {fetching: false},
    footerList: {fetching: false, data: []},
    categories: {fetching: false, data: []},
};

const getArchivesListRequest: CaseReducer<ArchivesState, PayloadAction<GetArchiveListParams>> = (state, {payload}) => {
    if (payload.loadingMore) {
        state.list.loadingMore = true;
        return;
    }
    state.list.fetching = true;
    delete state.list.error;
};

const getArchivesListSuccess: CaseReducer<ArchivesState, PayloadAction<ResponseState<ArchiveItem>>> = (state, {payload}) => {
    if (state.list.loadingMore) {
        state.list.data = [...state.list.data, ...payload.data];
        state.list.loadingMore = false;
    } else {
        state.list.data = payload.data;
        state.list.fetching = false;
    }
    state.list.meta = payload.meta;
};

const getArchivesListFailed: CaseReducer<ArchivesState, PayloadAction<string>> = (state, {payload}) => {
    state.list.loadingMore = false;
    state.list.fetching = false;
    state.list.error = payload;
};

const getFooterArchivesRequest: CaseReducer<ArchivesState, PayloadAction<GetArchiveListParams>> = (state) => {
    delete state.footerList.error;
    state.footerList.fetching = true;
};

const getFooterArchivesSuccess: CaseReducer<ArchivesState, PayloadAction<ResponseState<ArchiveItem>>> = (state, {payload}) => {
    state.footerList.data = payload.data;
    state.footerList.fetching = false;
    state.footerList.meta = payload.meta;
};

const getFooterArchivesFailed: CaseReducer<ArchivesState, PayloadAction<string>> = (state, {payload}) => {
    state.footerList.fetching = false;
    state.footerList.error = payload;
};

const getArchiveDetailRequest: CaseReducer<ArchivesState> = (state) => {
    state.detail.fetching = true;
};

const getArchiveDetailSuccess: CaseReducer<ArchivesState, PayloadAction<ArchiveItem>> = (state, {payload}) => {
    state.detail.fetching = false;
    state.detail.data = payload;
};

const getArchiveDetailFailed: CaseReducer<ArchivesState, PayloadAction<string>> = (state, {payload}) => {
    state.detail.fetching = false;
    state.detail.error = payload;
};

const getArchiveCategoriesRequest: CaseReducer<ArchivesState> = (state) => {
    delete state.categories.error;
    state.categories.fetching = true;
};

const getArchiveCategoriesSuccess: CaseReducer<ArchivesState, PayloadAction<ResponseState<ArchiveItemCategory>>> = (
    state,
    {payload},
) => {
    state.categories.data = payload.data;
    state.categories.fetching = false;
};

const getArchiveCategoriesFailed: CaseReducer<ArchivesState, PayloadAction<string>> = (state, {payload}) => {
    state.categories.fetching = false;
    state.categories.error = payload;
};

const getTrendingArchivesRequest: CaseReducer<ArchivesState> = (state) => {
    delete state.trendingList.error;
    state.trendingList.fetching = true;
};

const getTrendingArchivesSuccess: CaseReducer<ArchivesState, PayloadAction<ResponseState<ArchiveItem>>> = (
    state,
    {payload},
) => {
    state.trendingList.data = payload.data;
    state.trendingList.fetching = false;
};

const getTrendingArchivesFailed: CaseReducer<ArchivesState, PayloadAction<string>> = (state, {payload}) => {
    state.trendingList.fetching = false;
    state.trendingList.error = payload;
};

const getDestinationArchivesRequest: CaseReducer<ArchivesState> = (state) => {
    delete state.destination.error;
    state.destination.fetching = true;
};

const getDestinationArchivesSuccess: CaseReducer<ArchivesState, PayloadAction<ResponseState<ArchiveItem>>> = (
    state,
    {payload},
) => {
    state.destination.data = payload.data;
    state.destination.fetching = false;
    state.destination.meta = payload.meta;
};

const getDestinationArchivesFailed: CaseReducer<ArchivesState, PayloadAction<string>> = (state, {payload}) => {
    state.destination.fetching = false;
    state.destination.error = payload;
};

const getGuideArchivesRequest: CaseReducer<ArchivesState> = (state) => {
    delete state.guide.error;
    state.guide.fetching = true;
};

const getGuideArchivesSuccess: CaseReducer<ArchivesState, PayloadAction<ResponseState<ArchiveItem>>> = (state, {payload}) => {
    state.guide.data = payload.data;
    state.guide.fetching = false;
    state.guide.meta = payload.meta;
};

const getGuideArchivesFailed: CaseReducer<ArchivesState, PayloadAction<string>> = (state, {payload}) => {
    state.guide.fetching = false;
    state.guide.error = payload;
};

const getLastestArchivesRequest: CaseReducer<ArchivesState> = (state) => {
    delete state.lastest.error;
    state.lastest.fetching = true;
};

const getLastestArchivesSuccess: CaseReducer<ArchivesState, PayloadAction<ResponseState<ArchiveItem>>> = (
    state,
    {payload},
) => {
    state.lastest.data = payload.data;
    state.lastest.fetching = false;
    state.lastest.meta = payload.meta;
};

const getLastestArchivesFailed: CaseReducer<ArchivesState, PayloadAction<string>> = (state, {payload}) => {
    state.lastest.fetching = false;
    state.lastest.error = payload;
};

const getRelatedArchivesRequest: CaseReducer<ArchivesState> = (state) => {
    delete state.related.error;
    state.related.fetching = true;
};

const getRelatedArchivesSuccess: CaseReducer<ArchivesState, PayloadAction<ResponseState<ArchiveItem>>> = (
    state,
    {payload},
) => {
    state.related.data = payload.data;
    state.related.fetching = false;
    state.related.meta = payload.meta;
};

const getRelatedtArchivesFailed: CaseReducer<ArchivesState, PayloadAction<string>> = (state, {payload}) => {
    state.related.fetching = false;
    state.related.error = payload;
};

const archiveSlice = createSlice({
    name: 'archives',
    initialState,
    reducers: {
        getArchivesListRequest,
        getArchivesListSuccess,
        getArchivesListFailed,

        getArchiveDetailRequest,
        getArchiveDetailSuccess,
        getArchiveDetailFailed,

        getFooterArchivesRequest,
        getFooterArchivesSuccess,
        getFooterArchivesFailed,

        getArchiveCategoriesRequest,
        getArchiveCategoriesSuccess,
        getArchiveCategoriesFailed,

        getTrendingArchivesRequest,
        getTrendingArchivesSuccess,
        getTrendingArchivesFailed,

        getDestinationArchivesRequest,
        getDestinationArchivesSuccess,
        getDestinationArchivesFailed,

        getGuideArchivesRequest,
        getGuideArchivesSuccess,
        getGuideArchivesFailed,

        getLastestArchivesRequest,
        getLastestArchivesSuccess,
        getLastestArchivesFailed,

        getRelatedArchivesRequest,
        getRelatedArchivesSuccess,
        getRelatedtArchivesFailed,
    },
});

export const archiveActions = archiveSlice.actions;
export const archiveReducer = archiveSlice.reducer;
